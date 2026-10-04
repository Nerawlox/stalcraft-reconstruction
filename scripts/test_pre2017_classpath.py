"""Static regressions for classpath preparation; no Java or native code runs."""
import unittest

from audit_pre2017_classpath import class_types, has_member, inspect, references
from classfile_index import ClassInfo, Member
from prepare_pre2017_classpath import resource_name


def info(name, parent='', fields=(), methods=(), cp=()):
    return ClassInfo(name, parent, [], 1, list(fields), list(methods), set(), list(cp))


class ClasspathTests(unittest.TestCase):
    def test_arrays_and_method_descriptors(self):
        self.assertEqual(class_types('[[Ljava/lang/String;'), {'java/lang/String'})
        self.assertEqual(class_types('[[I'), set())
        subject = info('client/Test', methods=[Member(1, 'run', '([Lmissing/Arg;)Lmissing/Result;')])
        self.assertEqual(references(subject)[0], {'missing/Arg', 'missing/Result'})

    def test_inheritance_does_not_inherit_constructors(self):
        base = info('java/Base', methods=[Member(1, 'run', '()V'), Member(1, '<init>', '()V')])
        child = info('java/Child', parent=base.name)
        classes = {item.name: item for item in (base, child)}
        self.assertTrue(has_member(classes, child.name, 'run', '()V'))
        self.assertFalse(has_member(classes, child.name, '<init>', '()V'))
        base.superclass = child.name
        self.assertFalse(has_member(classes, child.name, 'absent', '()V'))

    def test_bootstrap_shadow_is_distinguished_from_active_caller(self):
        cp = [None, (1, b'java/Target'), (7, 1), (1, b'absent'), (1, b'()V'), (12, 3, 4), (10, 2, 5)]
        shadowed = info('java/Shadow', cp=cp)
        active = info('client/Active', cp=cp)
        boot = {'java/Target': info('java/Target'), 'java/Shadow': info('java/Shadow')}
        result = inspect({row.name: row for row in (shadowed, active)}, boot)
        self.assertEqual(result['unresolved_bootstrap_members'][0]['callers'], ['client/Active', 'java/Shadow'])
        self.assertEqual(result['unresolved_bootstrap_members'][0]['callers_not_shadowed_by_bootstrap'], ['client/Active'])

    def test_resource_boundary_and_unsafe_names(self):
        self.assertTrue(resource_name('fmlversion.properties'))
        self.assertTrue(resource_name('assets/map/r.-1.2.ol'))
        self.assertTrue(resource_name('lwjgl64.dll'))  # Preserve bytes, never load.
        self.assertFalse(resource_name('net/minecraft/Main.class'))
        self.assertFalse(resource_name('0123456789abcdef0123456789abcdef'))
        for value in ('../escape', '/absolute', 'C:/escape', 'folder\\escape', 'META-INF/X.RSA'):
            with self.assertRaises(ValueError):
                resource_name(value)


if __name__ == '__main__':
    unittest.main()
