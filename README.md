# EncodeAndDecode

## ENCODING:
Method 1) Encode without zero and no wrap-around.
Method 2) Encode without zero and wrap-around.
Method 3) Encode with zero and no wrap-around. //algorithm given below.
Method 4) Encode with zero and wrap-around.

**************************************
I. Inputs:
1) Input (argv): An image file in txt format
2) Console: Ask user for input
**************************************
II. Outputs:
1) Console: Display the four methods on the console as given in the above;
then ask the user to enter (1, 2, 3, or 4) for the method choice

2) Output (argv): the result of the encoded image, in the given format below.
*** Format of the encoded run-length:

20 15 0 9 // header information

2 // method 2 was used to encode

1 4 8 10 // startRow is 1, startCol is 4, color is 8, 10 pixels long

2 4 7 5 // startRow is 2, startCol is 4, color is 7, 5 pixels long

...

*******************************
IV. Algorithm in main
*******************************
step 0: - open all files
            - initializing those needed in the data structures
            - Read the image header and output the image header to outFile
            
step 1: Display to the console those four method and ask the user to input choice

step 2: method <- get from the user from the console
            // if method is not within 1 – 4 exit with error message
            
step 3: output method to outFile case of method
1: call method1 (inFile) 
2: call method2 (inFile)
3: call method3 (inFile) 
4: call method4 (inFile) 

step 4: closed all files

## DECODING:

**************************************
I. Input (argv): An encoded text file of an image, in the following format:

20 15 0 9       // header information

2                   // method 2 was used to encode

1 4 8 10        // startRow is 1, startCol is 4, color is 8, and 10 pixels long

2 4 7 5         // startRow is 2, startCol is 4, color is 7, and 5 pixels long
...

**************************************
II. Output (argv): the original image (including header information.)
                            Run this program with the results of four encoded run-length of run-length encoding project
                            
*******************************
IV. Algorithm in main
*******************************
step 0: inFile <- open input file
            outFile <- open a text file to write

step 1: Read the image header from inFile
            Write the header to outFile

step 2: methodUsed &lt;-- read from inFile if methodUsed is not within 1 – 4 exit with error message

step 3: case of methodUsed

step 4: closed all files
