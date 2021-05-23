# GlobalLogicTest

This is a Global Logic recruitment task.

## Description

Main point of the task was to implement an algorithm
which had to count occurrences of characters (or group of characters) of given
keyword based on length of the word they were part of in given text (without special chars).
The algorithm also calculates frequency of occurrence based on total number of
found keyword's character count and on total number of text's character count.

## Usage
Program uses CLI to ask user for three parameters:
* keyword (default: LOGIC)
* inputFilePath (default: src/resources/input.txt)
* outputFilePath (default: src/resources/output.txt)

## Data format

Input is expected to be a file containing any text, no matter the characters.
A line of output contains keyword's character or group of them, length of word it was found in and
calculated frequency based on total number of keyword's characters found.
Furthermore, end of outpout consists of total frequency of key characters
divided by total number of valid characters of the text.
