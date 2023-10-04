# CS-321-004 Group Project 28

This is the repository for Group Project 28 in CS-321 section 004. It contains the code for Functional Area 10.

## Functional Area 10
Declaration of Financial Support
- allows a U.S. citizen to state they will provide support to an alien and verify they have not already made a guarantee before that is active

## Our group participants
- Senan (Data Entry)
- Anthony (Review)
- Caiden (Approval)

## How to GitHub

Go to desired folder directory to work on the code, git bash there, and run the following commands.

Sets your username
```sh
git config --global user.name "YOUR_USERNAME"
```
Sets your email
```sh
git config --global user.email "YOUR_EMAIL"
```
Puts the latest version of the master branch into your directory, which also sets the remote origin
```sh
git clone https://github.com/sodrin/CS321-004.git
```

Make a new production branch to create changes to master, this will update the directory you are currently working in. It will not affect changes to the master branch until you check back out into master.
```sh
git checkout -b "PROD_NAME_HERE"
```
The -b flag is shorthand for the git branch (to create a branch) and git checkout (to switch to branch)

(This will update the current folder with the files from your current branch. Everytime you use the git checkout command, the folder directory on your machine will be updated with the selected branch's files.)

Now go and make the changes you want.

When you're ready to commit and push changes, do the following.

The -a flag adds all files to the commit, if you want to do individual files, you can do git add filename instead.
The -m flag adds a message to the commit, it should be a brief statement on what the changes are
```sh
git commit -am "commit message"
```
This will push the commit to the repository with your branch.
```sh
git push -u origin "PROD_NAME_HERE"
```

Now that the new branch is on the repo, you can go to the github page, go to pull requests, and create a pull request in order to merge your changes to the master branch.

Once the merge is completed and approved, remember to switch back to the master branch using 
```sh
git checkout master
```
and then using the command
```sh
git pull
```
to make sure the master branch on your machine is the latest version.

Don't forget to delete the branch you used to make the changes. This should be prompted after an approved pull request in the github page.

To remove it from your machine, you can simply do
```sh
git branch -d "PROD_NAME_HERE"
```

