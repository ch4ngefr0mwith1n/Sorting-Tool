```
Example 1: sorting numbers naturally without errors
$> java SortingTool -sortingType natural -dataType long
> 1 -2   33 4
> 42
> 1                 1
Total numbers: 7.
Sorted data: -2 1 1 1 4 42 333 

Example 2: sorting numbers by count without errors
$> java SortingTool -sortingType byCount -dataType long
> 1 -2   33 4
> 42
> 1                 1
Total numbers: 7.
-2: 1 time(s), 14%
4: 1 time(s), 14%
33: 1 time(s), 14%
42: 1 time(s), 14%
1: 3 time(s), 43%

Example 3: missing sorting type
$> java SortingTool -sortingType
No sorting type defined!

Example 4: missing data type
$> java SortingTool -dataType
No data type defined!

Example 5: invalid arguments and input value
$> java SortingTool -dataType long -sortingType natural -abc -def
"-abc" is not a valid parameter. It will be skipped.
"-def" is not a valid parameter. It will be skipped.
> a 2 -42
"a" is not a long. It will be skipped.
Total numbers: 2.
Sorted data: -42 2



Start test 1
> 1 -2   333 4
> 42
> 1                 1
Total numbers: 7.

Start test 2
> 1 -2   333 4
> 42
> 1                 1
Total numbers: 7.

Start test 3
> 1 -2   333 4
> 42
> 1                 1
Total numbers: 7.
-2: 1 time(s), 14%
4: 1 time(s), 14%
42: 1 time(s), 14%
333: 1 time(s), 14%
1: 3 time(s), 43%

Start test 4
> 1 -2   333 4
> 42
> 1                 1
Total words: 7.
-2: 1 time(s), 14%
333: 1 time(s), 14%
4: 1 time(s), 14%
42: 1 time(s), 14%
1: 3 time(s), 43%

Start test 5
> 1 -2   333 4
> 42
> 42
> 1                 1
Total lines: 4.
1                 1: 1 time(s), 25%
1 -2   333 4: 1 time(s), 25%
42: 2 time(s), 50%

Start test 6
> 1111 1111
> 22222
> 3
> 44
Total lines: 4.
1111 1111: 1 time(s), 25%
22222: 1 time(s), 25%
3: 1 time(s), 25%
44: 1 time(s), 25%

Start test 7
> 1111 1111
> 22222
> 3
> 44
Total words: 5.
22222: 1 time(s), 20%
3: 1 time(s), 20%
44: 1 time(s), 20%
1111: 2 time(s), 40%

Start test 8
> 1111 1111
> 22222
> 3
> 44
Total numbers: 5.
3: 1 time(s), 20%
44: 1 time(s), 20%
22222: 1 time(s), 20%
1111: 2 time(s), 40%

Start test 9
No sorting type defined!
> 1 -2   333 4
> 42
> 1                 1
Total words: 7.

Start test 10
"-abc" is not a valid parameter. It will be skipped.
> 1 -2   333 4
> 42
> 1                 1
Total numbers: 7.
-2: 1 time(s), 14%
4: 1 time(s), 14%
42: 1 time(s), 14%
333: 1 time(s), 14%
1: 3 time(s), 43%

Start test 11
"-cde" is not a valid parameter. It will be skipped.
> 1111 1111
> 22222
> 3
> 44
Total lines: 4.
1111 1111: 1 time(s), 25%
22222: 1 time(s), 25%
3: 1 time(s), 25%
44: 1 time(s), 25%

Start test 12
No sorting type defined!
> 1111 1111
> 22222
> 3
> 44
Total lines: 4.

```
