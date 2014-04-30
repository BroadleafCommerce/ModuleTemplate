# Module Template

A sample Broadleaf module that has default placeholders for most of the relevant files a module might need.

## Basic setup of a new module

1. Make a copy of this project.

2. Remove the `.git` folder from the copy

3. Before importing into your IDE, edit pom.xml in a text editor and replace MYMODULE with the appropriate module name

4. Import into your IDE

5. Find and replace all instances of MYMODULE (file names, directory names, and contents of files) with the appropriate module name.   Below is a helpful unix command for renaming the files ... change "new-module-name" to your module name.

```
for i in `find . | grep MYMODULE`; do mv $i `echo $i | sed "s/MYMODULE/new-module-name/g"`;done

```

6. Delete all placeholder.git files

## Next steps for a new module

This skeleton template has a lot of files. You might not be using all of them. For example, if the module doesn't do any weaving into core Broadleaf entities, you are able to combine `bl-MYMODULE-applicationContext.xml` and `bl-MYMODULE-base-applicationContext.xml`. If you don't have any special caching configuration, you can remove the ehcache file as well as the reference to it in the XML files.

Basically, don't check in unneeded things. Be dilligent about your work and clean up things that don't belong.
