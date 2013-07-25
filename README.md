# Module Template

A sample Broadleaf module that has default placeholders for most of the relevant files a module might need.

## How to use

1. Make a copy of this project.

2. Rename instances of MYMODULE to something more appropriate.

> There are a lot of instances of MYMODULE, including some directory names, so using an IDE's search function is recommended.

3. Remove all placeholder.git files once actual things reside in those directories.

4. If this module will not need to weave in any transformations to Broadleaf entities that reside outside of this module, you may combine `bl-MYMODULE-applicationContext.xml` and `bl-MYMODULE-base-applicationContext.xml`

5. Clean up any placeholder files that you're not leveraging. Any empty files or instances of MYMODULE should not exist.
