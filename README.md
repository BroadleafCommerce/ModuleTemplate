# Module Template

A sample Broadleaf module that has default placeholders for most of the relevant files a module might need.

## Basic setup of a new module

1. Make a copy of this project.
2. Remove the `.git` folder from the copy
3. Before importing into your IDE, edit pom.xml in a text editor and replace MYMODULE with the appropriate module name
4. Import into your IDE
5. Find and replace all instances of MYMODULE (file names, directory names, and contents of files) with the appropriate module name.   Below is a helpful unix command for renaming the files ... change "new-module-name" to your module name.

    ```sh
    for i in `find . | grep MYMODULE`; do mv $i `echo $i | sed "s/MYMODULE/new-module-name/g"`;done

    ```

7.  Reserve Module ID range (all SQL that originates from this module should use IDs in this range.)   Update the following file ... 
https://github.com/BroadleafCommerce/docs-internal/blob/master/Module%20IDs.md
8. Delete all placeholder.git files
9. Create a new GitHub project for your module 
10. Ensure that you are on a `develop-1.0.x` branch (it must be in the format `develop-a.b.x` where `a` and `b` are numbers)
11. Add the `origin` remote to your new Github project:

    ```console
    git remote add origin git@github.com:BroadleafCommerce/MYMODULE.git
    ```

12. Push up your project with a `-u` to automatically track your branch:

    ```console
    git push -u
    ```

## Next steps for a new module

### Remove unnecessary template files

This skeleton template has a lot of files. You might not be using all of them. For example, if the module doesn't do any weaving into core Broadleaf entities, you are able to combine `bl-MYMODULE-applicationContext.xml` and `bl-MYMODULE-base-applicationContext.xml`. If you don't have any special caching configuration, you can remove the ehcache file as well as the reference to it in the XML files.

Basically, don't check in unneeded things. Be dilligent about your work and clean up things that don't belong.

### Create a new Nexus repository

This requires an administrator account within Nexus.

1. Go to [the Broadleaf Nexus](http://nexus.broadleafcommerce.org/nexus/index.html) and log in
2. Click on 'Repositories' to the left
3. Create a Releases repository
4. Hit 'Add -> Hosted Repository' at the top and then in the form that appears at the bottom fill out the following
  - **Repository ID** - usually `MYMODULE-releases` all lowercase
  - **Repository Name** - Usually `MYMODULE Releases` in correctly-spaced capitalization
  - Leave all other defaults
  - Hit 'Save'

5. Now create a Snapshots repository
  - Hit 'Add -> Hosted Repository' to add another repo
  - **Repository ID** - usually `MYMODULE-snapshots` all lowercase
  - **Repository Name** - usually `MYMODULE Snapshots` in correctly-spaced capitalization
  - **Repository Policy** - Snapshot (this changes the **Deployment Policy** to 'Allow Redeploy')
  - leave everything else
  - Hit 'Save'

### Validate that the `<scm>` section of the `pom.xml` is correct

All of this information should point to real things or the next step will fail

### Create a `Jenkinsfile` for Jenkins to build the project

The most up-to-date information on what the contents of your `Jenkinsfile` should be is [in the Jenkins Pipeline library project](https://github.com/BroadleafCommerce/jenkins-pipeline-library#usage). Once you push up this change, Jenkins will automatically build and deploy it onto the nexus
