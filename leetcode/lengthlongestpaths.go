package main

/*Suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.
*/

func lengthLongegstPath(input string) int {
	//Path to a file
	//find the path right down to the end of the directory string
	isFileName := false
	var name string
	for i := 0; i < len(input); i++ {
		if input[i] == '.' {
			isFileName = true
		}
		if input[i] == '\n' {
			// This means that the dir or file is here
			name = input[0 : i+1]
			break
		}
	}

	//name is the name of the either the directory or the file.
	// if it is a file, there is no more recursion left to do and
	// it will be okay to just return the length of the string
	// that was generated.
}
