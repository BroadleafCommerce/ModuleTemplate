# Module Template

A sample Broadleaf module that has default placeholders for most of the relevant files a module might need.

## Basic setup of a new module

1. Make a copy of this project.

2. Remove the `.git` folder from the copy

3. Before importing into your IDE, edit pom.xml in a text editor

 - replace `My Module` with the appropriate meaningful module name
 - replace `my-module` with the appropriate module artifactId

4. Import into your IDE

5. Find and replace all instances of MY MODULE (file names, directory names, and contents of files) with the appropriate module name.   

- Replace `MyModule` by `YourNewModule` ( Class naming convention)
- Replace `mymodule` by `yournewmodule` ( Package naming convention)
- Replace `my-module` by `your-new-module` (xml,js,html filename convention)
- Replace `my_module` by `your_new_module` (sql file filename convention)
- Replace `My Module` by `Your New Module` ( Module full name)

Below is a helpful unix command for renaming the files

```
for i in `find . | grep MyModule`; do mv $i `echo $i | sed "s/MyModule/YourNewModule/g"`;done
for i in `find . | grep mymodule`; do mv $i `echo $i | sed "s/mymodule/yournewmodule/g"`;done
for i in `find . | grep my-module`; do mv $i `echo $i | sed "s/my-module/your-new-module/g"`;done
for i in `find . | grep my_module`; do mv $i `echo $i | sed "s/my_module/your_new_module/g"`;done
```

Below is a helpful unix command for replacing content in the files

```
find . -type f -exec sed -i "s/MyModule/YourNewModule/g" {} \; 
find . -type f -exec sed -i "s/mymodule/yournewmodule/g" {} \; 
find . -type f -exec sed -i "s/my-module/your-new-module/g" {} \; 
find . -type f -exec sed -i "s/my_module/your_new_module/g" {} \; 
find . -type f -exec sed -i "s/My Module/Your New Module/g" {} \; 
```

7.  Reserve Module ID range (all SQL that originates from this module should use IDs in this range.)   Update the following file ... 
https://github.com/BroadleafCommerce/docs-internal/blob/master/Module%20IDs.md

8. Delete all placeholder.git files

## Next steps for a new module

This skeleton template has a lot of files. You might not be using all of them. For example, if the module doesn't do any weaving into core Broadleaf entities, you are able to combine `bl-my-module-applicationContext.xml` and `bl-my-module-base-applicationContext.xml`. If you don't have any special caching configuration, you can remove the ehcache file as well as the reference to it in the XML files.

Basically, don't check in unneeded things. Be dilligent about your work and clean up things that don't belong.
