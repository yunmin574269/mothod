package com.mothod;

import java.util.*;

public class ListUtil {

    //list<map<String,Integer>>排序
    public static void sort(List<Map<String, Integer>> data,String value,int desc) {

        Collections.sort(data, new Comparator<Map>() {

            public int compare(Map o1, Map o2) {

                Integer a =  Integer.parseInt((String) o1.get(value)) ;
                Integer b =  Integer.parseInt((String) o2.get(value));
                if(desc==1){
                    // 升序
                    return a.compareTo(b);
                }else{
                    // 降序
                    return b.compareTo(a);
                }

            }
        });
    }

    //一个Map泛型的集合 如果包含某key  就移除
    public static List<Map> mapListContainsKey(List<Map> list, String key) {
        if (list != null) {
            ListIterator<Map> mapListIterator = list.listIterator();
            while (mapListIterator.hasNext()) {
                Map next = mapListIterator.next();
                boolean b = next.containsKey(key);
                if (b) {
                    mapListIterator.remove();
                }
            }
        }
        return list;
    }

    //根据 Int value 对map集合进行升序排列
    public static List<Map.Entry<String, Object>> sortMapByValue(Map<String, Object> map, final String orderBy) {
        //这里将map.entrySet()转换成list
        List<Map.Entry<String, Object>> list = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, Object>>() {

            //升序排序
            public int compare(Map.Entry<String, Object> o1,
                               Map.Entry<String, Object> o2) {
                Object v1 = o1.getValue();
                Object v2 = o2.getValue();

                if (orderBy.equals("DESC")) {
                    if (v1 instanceof Double) {
                        return new Double(v2.toString()).compareTo(new Double(v1.toString()));
                    } else if (v1 instanceof Integer) {
                        return new Integer(v2.toString()).compareTo(new Integer(v1.toString()));
                    }

                } else {
                    if (v1 instanceof Double) {
                        return new Double(v1.toString()).compareTo(new Double(v2.toString()));
                    } else if (v1 instanceof Integer) {
                        return new Integer(v1.toString()).compareTo(new Integer(v2.toString()));
                    }


                }
                return 0;
            }
        });
        return list;
    }

    //treemap 根据key排序
    public static ArrayList<TreeMap<String, Object>> sortArrayList_MapByOneKey(ArrayList<TreeMap<String, Object>> list, final String key, final String orderBy) {
        Collections.sort(list, new Comparator<TreeMap<String, Object>>() {
            public int compare(TreeMap<String, Object> o1, TreeMap<String, Object> o2) {
                if (orderBy.equals("DESC")) {
                    return o2.get(key).toString().compareTo(o1.get(key).toString());
                } else {
                    return o1.get(key).toString().compareTo(o2.get(key).toString());
                }
            }
        });
        return list;
    }
}
