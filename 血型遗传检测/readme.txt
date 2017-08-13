题目描述
血型遗传对照表如下：
父母血型	子女会出现的血型	子女不会出现的血型
O与O	O	A,B,AB
A与O	A,O	B,AB
A与A	A,O	B,AB
A与B	A,B,AB,O	——
A与AB	A,B,AB	O
B与O	B,O	A,AB
B与B	B,O	A,AB
B与AB	A,B,AB	O
AB与O	A,B	O,AB
AB与AB	A,B,AB	O
请实现一个程序，输入父母血型，判断孩子可能的血型。
给定两个字符串father和mother，代表父母的血型,请返回一个字符串数组，代表孩子的可能血型(按照字典序排列)。
测试样例：
”A”,”A”
返回：[”A”,“O”]