# project-basement
Personal project, just fun for author.

##1.StringUtils.isEmpty() 与 StringUtils.isBlank()区别
1.1 isEmpty() : 判断字符串是否为空，当字符串为null、""时返回为true,当字符串为" "、"abc"时返回为false;<br/>
1.2 isBlank() : 判断字符串是否为空白，当字符串为null、""、" "时，返回为true,当字符串为"abc"时，返回为false;<br/>

##2.集合是否为空的判断
2.1 单列集合(Set/List)判断使用CollectionUtils.isEmpty(Set/List set/list);<br/>
2.2 双列集合(Map)判断使用MapUtils.isEmpty(Map map);<br/>

##3.数组为空的判断
3.1 判断数组是否为空，使用ArrayUtils.isEmpty(Object[] array);<br/>
