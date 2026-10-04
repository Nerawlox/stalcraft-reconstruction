"""Inventory recovered class dependencies against a supplied ordinary Java runtime.

Reads ZIP/class bytes only. Constant-pool references may be unused or optional;
this is deliberately not a Java verifier or a prediction of startup success.
"""
from collections import Counter, defaultdict
from pathlib import Path
import argparse
import hashlib
import json
import re
import zipfile

from classfile_index import parse_class


BOOT_PREFIXES = ('java/', 'javax/', 'sun/', 'com/sun/', 'org/w3c/', 'org/xml/')


def sha(path):
    with path.open('rb') as stream:
        return hashlib.file_digest(stream, 'sha256').hexdigest() if hasattr(hashlib, 'file_digest') else hashlib.sha256(stream.read()).hexdigest()


def descriptor_types(value):
    return set(re.findall(r'L([^;]+);', value))


def class_types(value):
    return descriptor_types(value) if value.startswith('[') else {value}


def utf(info, index):
    return info.constant_pool[index][1].decode('utf-8')


def references(info):
    types = set()
    members = set()
    for row in info.constant_pool:
        if not row:
            continue
        if row[0] == 7:
            types.update(class_types(utf(info, row[1])))
        elif row[0] == 12:
            types.update(descriptor_types(utf(info, row[2])))
        elif row[0] == 16:
            types.update(descriptor_types(utf(info, row[1])))
        elif row[0] in (9, 10, 11):
            owner = utf(info, info.constant_pool[row[1]][1])
            name_type = info.constant_pool[row[2]]
            members.add((row[0], owner, utf(info, name_type[1]), utf(info, name_type[2])))
    for member in info.fields + info.methods:
        types.update(descriptor_types(member.descriptor))
    return types, members


def has_member(classes, owner, name, descriptor, field=False):
    """Declaration/hierarchy existence only: no access or invocation checks."""
    if owner.startswith('['):
        owner = 'java/lang/Object'
    pending = [owner]
    seen = set()
    while pending:
        current = pending.pop()
        if current in seen:
            continue
        seen.add(current)
        info = classes.get(current)
        if info is None:
            continue
        group = info.fields if field else info.methods
        if any(member.name == name and member.descriptor == descriptor for member in group):
            return True
        if not field and name in ('<init>', '<clinit>'):
            continue
        pending.extend(info.interfaces)
        if info.superclass:
            pending.append(info.superclass)
    return False


def inspect(application, boot):
    available = dict(application)
    available.update(boot)  # Ordinary bootstrap classes take precedence.
    missing_types = defaultdict(set)
    missing_members = defaultdict(set)
    polymorphic = defaultdict(set)
    native = []
    bridge = application.get('net/minecraft/launchwrapper/LaunchClassLoader')
    ordinary_loader = boot.get('java/lang/ClassLoader')
    type_sites = member_sites = 0
    for caller, info in sorted(application.items()):
        types, members = references(info)
        type_sites += len(types)
        for name in types:
            if name not in available:
                missing_types[name].add(caller)
        for tag, owner, name, descriptor in members:
            if not owner.startswith(BOOT_PREFIXES) or owner not in boot:
                continue
            member_sites += 1
            if owner == 'java/lang/invoke/MethodHandle' and name in ('invoke', 'invokeExact'):
                polymorphic[(owner, name, descriptor)].add(caller)
                continue
            if not has_member(boot, owner, name, descriptor, tag == 9):
                missing_members[(tag, owner, name, descriptor)].add(caller)
        for method in info.methods:
            if method.access & 0x100:
                native.append({'class': caller, 'method': method.name, 'descriptor': method.descriptor})
    return {
        'application_classes': len(application), 'bootstrap_classes': len(boot),
        'type_reference_sites': type_sites, 'bootstrap_member_reference_sites': member_sites,
        'unresolved_types': [{'class': name, 'caller_count': len(callers), 'callers': sorted(callers)}
                             for name, callers in sorted(missing_types.items())],
        'unresolved_bootstrap_members': [
            {'kind': 'field' if key[0] == 9 else 'method', 'owner': key[1],
             'name': key[2], 'descriptor': key[3], 'caller_count': len(callers), 'callers': sorted(callers),
             'callers_not_shadowed_by_bootstrap': sorted(callers - boot.keys())}
            for key, callers in sorted(missing_members.items())],
        'signature_polymorphic_references_excluded': len(polymorphic),
        'application_native_methods': native,
        'bootstrap_names_also_in_application': sorted(set(application) & set(boot)),
        'launch_classloader_methods': [
            {'name': method.name, 'descriptor': method.descriptor,
             'code_bytes': len(method.code or b''),
             'code_sha256': hashlib.sha256(method.code).hexdigest() if method.code is not None else None,
             'code_hex': method.code.hex() if method.code is not None else None}
            for method in (bridge.methods if bridge else [])
            if method.name in ('<init>', 'loadClass', 'addURL', 'registerTransformer', 'getClassBytes')],
        'ordinary_classloader_findclass_declarations': [
            {'name': method.name, 'descriptor': method.descriptor, 'access_flags': method.access}
            for method in (ordinary_loader.methods if ordinary_loader else [])
            if method.name == 'findClass'],
    }


def inventory(paths):
    classes = {}
    versions = Counter()
    duplicates = []
    archives = []
    entry_hashes = {}
    for path in paths:
        class_count = resource_count = 0
        with zipfile.ZipFile(path) as archive:
            for entry in archive.infolist():
                if entry.is_dir():
                    continue
                if not entry.filename.endswith('.class'):
                    resource_count += 1
                    continue
                data = archive.read(entry)
                info = parse_class(data)
                if info.name + '.class' != entry.filename:
                    raise ValueError('Inconsistent class path: ' + entry.filename)
                class_count += 1
                versions[int.from_bytes(data[6:8], 'big')] += 1
                digest = hashlib.sha256(data).hexdigest()
                if info.name in classes:
                    duplicates.append({'class': info.name, 'later_archive': str(path),
                                       'identical_bytes': entry_hashes[info.name] == digest})
                else:
                    classes[info.name] = info
                    entry_hashes[info.name] = digest
        archives.append({'path': str(path), 'sha256': sha(path),
                         'classes': class_count, 'resources': resource_count})
    return classes, {'archives': archives, 'major_versions': dict(sorted(versions.items())),
                     'duplicate_classes': duplicates}


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--application', type=Path, action='append', required=True)
    parser.add_argument('--bootstrap', type=Path, action='append', required=True)
    parser.add_argument('--report', type=Path, required=True)
    args = parser.parse_args()
    inputs = args.application + args.bootstrap
    if args.report.resolve() in {path.resolve() for path in inputs} or args.report.exists():
        raise ValueError('Report must be a new path distinct from inputs')
    application, application_inventory = inventory(args.application)
    boot, boot_inventory = inventory(args.bootstrap)
    report = {'scope': 'Static constant-pool/declaration inventory; no classes loaded or initialized',
              'limitations': ['Unused constant-pool entries and optional dependencies can appear unresolved.',
                              'Reflection, annotations, generic signatures, dynamically generated classes, native exports and resource availability are not resolved.',
                              'Member checks establish only declaration existence in the supplied bootstrap hierarchy; access, opcode compatibility and verification are not checked.',
                              'First supplied application archive wins duplicate application names; bootstrap classes take precedence over application names.'],
              'application_inventory': application_inventory, 'bootstrap_inventory': boot_inventory,
              **inspect(application, boot)}
    args.report.parent.mkdir(parents=True, exist_ok=True)
    args.report.write_text(json.dumps(report, indent=2) + '\n', encoding='utf-8')
    print(json.dumps({'application_classes': report['application_classes'],
                      'bootstrap_classes': report['bootstrap_classes'],
                      'unresolved_types': len(report['unresolved_types']),
                      'unresolved_bootstrap_members': len(report['unresolved_bootstrap_members']),
                      'native_methods': len(report['application_native_methods']),
                      'report': str(args.report)}))


if __name__ == '__main__':
    main()
