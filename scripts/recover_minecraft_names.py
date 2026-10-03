"""Infer pre-2017 Minecraft class identities from SRG declarations and type constraints.

Does not execute bytecode or rename original snapshots. Ambiguous candidates remain
unmapped. Inputs are explicitly supplied local JARs; output is auditable JSON.
"""
from collections import Counter, defaultdict
from pathlib import Path
import argparse
import hashlib
import json
import re
from classfile_index import read_jar, map_descriptor, descriptor_parts
from bytecode_fingerprint import class_fingerprint


def digest(path):
    return hashlib.sha256(path.read_bytes()).hexdigest()


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--input', required=True, type=Path)
    parser.add_argument('--vanilla', required=True, type=Path)
    parser.add_argument('--srg', required=True, type=Path)
    parser.add_argument('--output', required=True, type=Path)
    args = parser.parse_args()
    opcode_path = args.srg.with_name('opcode-map.json')
    lengths = {row['standard']: row['length'] for row in json.loads(opcode_path.read_text())['rows']
               if row['standard'] is not None}
    current, vanilla = read_jar(args.input), read_jar(args.vanilla)
    classes, fields, methods = {}, {}, {}
    ref_fields, ref_methods = defaultdict(dict), defaultdict(list)
    for line in args.srg.read_text(encoding='utf-8').splitlines():
        parts = line.split('#', 1)[0].split()
        if not parts:
            continue
        if parts[0] == 'CL:':
            classes[parts[1]] = parts[2]
        elif parts[0] == 'FD:':
            fields[parts[1]] = parts[2]
        elif parts[0] == 'MD:':
            methods[(parts[1], parts[2])] = (parts[3], parts[4])
            owner, name = parts[3].rsplit('/', 1)
            ref_methods[owner].append((name, parts[4]))
    parents, kinds, reference = {}, {}, {}
    fingerprints, string_owners = defaultdict(set), defaultdict(set)

    def fingerprint(info):
        return (info.access & (0x0200 | 0x2000 | 0x4000),
                tuple(sorted((f.access & 0x00d8, descriptor_parts(f.descriptor)[0]) for f in info.fields)),
                tuple(sorted((m.access & 0x05c8, m.name.startswith('<'), descriptor_parts(m.descriptor)[0]) for m in info.methods)))
    for name, info in vanilla.items():
        owner = classes.get(name)
        if not owner:
            continue
        reference[owner] = info
        fingerprints[fingerprint(info)].add(owner)
        for literal in info.string_constants:
            if len(literal) >= 4:
                string_owners[literal].add(owner)
        parents[owner] = classes.get(info.superclass, info.superclass)
        kinds[owner] = info.access & (0x0200 | 0x2000 | 0x4000)
        for field in info.fields:
            target = fields.get(name + '/' + field.name)
            if target:
                field_owner, field_name = target.rsplit('/', 1)
                ref_fields[field_owner][field_name] = map_descriptor(field.descriptor, classes)
    field_owners, method_owners = defaultdict(set), defaultdict(set)
    for owner, members in ref_fields.items():
        for name in members:
            field_owners[name].add(owner)
    for owner, members in ref_methods.items():
        for name, _ in members:
            method_owners[name].add(owner)
    targets = set(classes.values())
    mapping = {name: name for name in current if name in targets}
    evidence = {name: {'kind': 'already_named'} for name in mapping}

    def eligible(name):
        return '/' not in name or name.startswith('net/minecraft/')

    def compatible_name(name, target):
        if name in mapping:
            return mapping[name] == target
        if name not in current:
            return name == target
        if not eligible(name):
            return name == target
        return True

    def compatible_descriptor(actual, expected):
        a, b = descriptor_parts(actual), descriptor_parts(expected)
        return a[0] == b[0] and all(compatible_name(x, y) for x, y in zip(a[1], b[1]))

    def compatible_class(name, target):
        info = current[name]
        if target in kinds and (info.access & (0x0200 | 0x2000 | 0x4000)) != kinds[target]:
            return False
        if target in parents and not compatible_name(info.superclass, parents[target]):
            return False
        if target in reference:
            expected = [classes.get(value, value) for value in reference[target].interfaces]
            # Forge can add interfaces. Every vanilla edge must still have a
            # compatible actual edge, using distinct positions for each edge.
            options = [[index for index, value in enumerate(info.interfaces)
                        if compatible_name(value, edge)] for edge in expected]

            def assign(index, used):
                return index == len(options) or any(
                    position not in used and assign(index + 1, used | {position})
                    for position in options[index])

            if not assign(0, set()):
                return False
        return True

    rounds = []
    for iteration in range(12):
        proposals = defaultdict(list)
        for name, info in current.items():
            if name in mapping or not eligible(name):
                continue
            votes = Counter()
            field_names = {member.name for member in info.fields}
            method_names = {member.name for member in info.methods}
            for value in sorted(field_names):
                for owner in sorted(field_owners.get(value, ())):
                    votes[owner] += 4
            for value in sorted(method_names):
                for owner in sorted(method_owners.get(value, ())):
                    votes[owner] += 1
            candidates = []
            for target, _ in votes.most_common(6):
                if target in mapping.values() or not compatible_class(name, target):
                    continue
                matched_fields = [field for field in info.fields if field.name in ref_fields[target]]
                target_methods = defaultdict(list)
                for method, descriptor in ref_methods[target]:
                    target_methods[method].append(descriptor)
                matched_methods = [method for method in info.methods if method.name in target_methods]
                # A candidate's own identity resolves self-references during testing.
                mapping[name] = target
                valid = all(compatible_descriptor(f.descriptor, ref_fields[target][f.name]) for f in matched_fields)
                valid = valid and all(any(compatible_descriptor(m.descriptor, d) for d in target_methods[m.name]) for m in matched_methods)
                del mapping[name]
                unique_fields = sum(len(field_owners[f.name]) == 1 for f in matched_fields)
                unique_methods = sum(len(method_owners[m.name]) == 1 for m in matched_methods)
                if valid and len(matched_fields) + len(matched_methods) >= 3 and (unique_fields or unique_methods >= 2):
                    candidates.append((len(matched_fields) * 4 + len(matched_methods), target,
                                       {'kind': 'declared_srg_members', 'field_matches': len(matched_fields),
                                        'method_matches': len(matched_methods), 'unique_fields': unique_fields,
                                        'unique_methods': unique_methods,
                                        'sample_fields': [f.name for f in matched_fields[:6]],
                                        'sample_methods': [m.name for m in matched_methods[:6]]}))
            candidates.sort(reverse=True, key=lambda row: row[0])
            if candidates and (len(candidates) == 1 or candidates[0][0] >= candidates[1][0] * 2):
                _, target, proof = candidates[0]
                proposals[target].append((name, proof))
        added = 0
        for target, candidates in proposals.items():
            if len(candidates) == 1:
                name, proof = candidates[0]
                mapping[name], evidence[name] = target, proof
                added += 1
        # Propagate field and method type identities only from mapped declarations.
        constraints = defaultdict(lambda: defaultdict(set))
        for name, target in list(mapping.items()):
            info = current[name]
            pairs = [(f.descriptor, ref_fields[target][f.name], 'field:' + f.name)
                     for f in info.fields if f.name in ref_fields[target]]
            if target in parents and info.superclass in current and info.superclass not in mapping and eligible(info.superclass):
                parent = parents[target]
                if parent in targets and compatible_class(info.superclass, parent):
                    constraints[info.superclass][parent].add(name + '#superclass')
            for method in info.methods:
                options = {descriptor for member, descriptor in ref_methods[target]
                           if member == method.name and compatible_descriptor(method.descriptor, descriptor)}
                if len(options) == 1:
                    pairs.append((method.descriptor, next(iter(options)), 'method:' + method.name + method.descriptor))
            for actual, expected, member in pairs:
                if not compatible_descriptor(actual, expected):
                    continue
                a, b = descriptor_parts(actual)[1], descriptor_parts(expected)[1]
                for old, new in zip(a, b):
                    if old in current and old not in mapping and eligible(old) and new in targets and compatible_class(old, new):
                        constraints[old][new].add(name + '#' + member)
        reverse = defaultdict(set)
        for name, candidates in constraints.items():
            if len(candidates) == 1:
                target, sites = next(iter(candidates.items()))
                if len(sites) >= 2 and target not in mapping.values():
                    reverse[target].add(name)
        for target, names in reverse.items():
            if len(names) == 1:
                name = next(iter(names))
                mapping[name] = target
                evidence[name] = {'kind': 'descriptor_constraints',
                                  'support_count': len(constraints[name][target]),
                                  'sites': sorted(constraints[name][target])[:12]}
                added += 1
        # Unmodified declaration layouts can resolve classes whose members were
        # completely renamed. Require a unique layout candidate, known type
        # agreement, and a class-specific string or many typed references.
        structural = defaultdict(list)
        for name, info in current.items():
            if name in mapping or not eligible(name):
                continue
            candidates = []
            for target in fingerprints.get(fingerprint(info), ()):
                if target in mapping.values() or not compatible_class(name, target):
                    continue
                ref = reference[target]
                mapping[name] = target
                valid, known = True, 0
                for actuals, expected_members in ((info.fields, ref.fields), (info.methods, ref.methods)):
                    # Match multisets, not declaration order, because obfuscators
                    # may reorder members. Ambiguous reference types stay wildcards.
                    counts = Counter((member.access & (0x00d8 if actuals is info.fields else 0x05c8),
                                      member.name.startswith('<') if actuals is info.methods else False,
                                      map_descriptor(member.descriptor, classes)) for member in expected_members)
                    for member in actuals:
                        flags = member.access & (0x00d8 if actuals is info.fields else 0x05c8)
                        constructor = member.name.startswith('<') if actuals is info.methods else False
                        options = [key for key, count in counts.items() if count and key[:2] == (flags, constructor)
                                   and compatible_descriptor(member.descriptor, key[2])]
                        if len(options) != 1:
                            valid = False
                            break
                        key = options[0]
                        counts[key] -= 1
                        known += sum(old in mapping or old not in current for old in descriptor_parts(member.descriptor)[1])
                    if not valid:
                        break
                del mapping[name]
                unique_literals = sorted(value for value in info.string_constants & ref.string_constants
                                         if string_owners[value] == {target})
                member_count = len(info.fields) + len(info.methods)
                code_match = False
                if valid and member_count >= 5 and not unique_literals and known >= 10:
                    actual_names = dict(mapping)
                    actual_names[name] = target
                    reference_names = dict(classes)
                    accepted = set(mapping.values()) | {target}
                    code_match = class_fingerprint(info, lengths, actual_names, accepted) == class_fingerprint(ref, lengths, reference_names, accepted)
                if valid and member_count >= 5 and ((unique_literals and known >= 2) or code_match):
                    candidates.append((target, {'kind': 'declaration_fingerprint', 'members': member_count,
                                                'known_type_occurrences': known,
                                                'instruction_fingerprint_match': code_match,
                                                'unique_string_anchors': [value.decode('utf-8', 'backslashreplace') for value in unique_literals[:8]]}))
            if len(candidates) == 1:
                target, proof = candidates[0]
                structural[target].append((name, proof))
        for target, candidates in structural.items():
            if len(candidates) == 1:
                name, proof = candidates[0]
                mapping[name], evidence[name] = target, proof
                added += 1
        rounds.append({'round': iteration + 1, 'added': added, 'mapped_total': len(mapping)})
        if not added:
            break
    # Audit descriptor and inheritance consistency after all propagation rounds.
    issues = []
    for name, target in mapping.items():
        info = current[name]
        if not compatible_class(name, target):
            issues.append({'class': name, 'target': target, 'reason': 'inheritance or class kind'})
        for field in info.fields:
            if field.name in ref_fields[target] and not compatible_descriptor(field.descriptor, ref_fields[target][field.name]):
                issues.append({'class': name, 'member': field.name, 'reason': 'field descriptor'})
        for method in info.methods:
            options = [d for n, d in ref_methods[target] if n == method.name]
            if options and not any(compatible_descriptor(method.descriptor, d) for d in options):
                issues.append({'class': name, 'member': method.name, 'reason': 'method descriptor'})
    if len(set(mapping.values())) != len(mapping):
        raise ValueError('Non-bijective class mapping')
    output = {'inputs': {key: {'path': str(value), 'sha256': digest(value)}
                         for key, value in [('classes', args.input), ('vanilla', args.vanilla), ('srg', args.srg)]},
              'scope': 'Minecraft class identities only; no original STALCRAFT names invented',
              'method': 'Declared SRG members, vanilla field descriptors, constrained type propagation, one-to-one targets',
              'rounds': rounds, 'mapped_count': len(mapping),
              'renamed_count': sum(a != b for a, b in mapping.items()),
              'evidence_counts': dict(Counter(row['kind'] for row in evidence.values())),
              'consistency_issues': issues,
              'rows': [{'original': name, 'named': mapping[name], 'evidence': evidence[name]} for name in sorted(mapping)],
              'unmapped_default_classes': sorted(name for name in current if '/' not in name and name not in mapping)}
    args.output.parent.mkdir(parents=True, exist_ok=True)
    args.output.write_text(json.dumps(output, indent=2) + '\n', encoding='utf-8')
    print(json.dumps({key: output[key] for key in ('mapped_count', 'renamed_count', 'evidence_counts', 'consistency_issues', 'rounds')}), flush=True)
    if issues:
        raise SystemExit(1)


if __name__ == '__main__':
    main()
