package 简单错误记录;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static class Error {
        private String name;
        private int line;
        private int count;

        @Override
        public String toString() {
            return name + " " + line + " " + count;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Error> errors = new ArrayList<>();
        while (input.hasNext()) {
            String name = input.next();
            int num = input.nextInt();
            Error record = new Error();
            name = name.substring(name.lastIndexOf("\\") + 1);
            System.out.println(name);
            if (name.length() > 16) {
                name = name.substring(name.length() - 16);
            }
//这里需要学习substring的方法。还有lastindexof()方法
            boolean flag = true;
            //重复检验
            for (Error error : errors) {
                if (name.equals(error.name) && num == error.line) {
                    error.count++;
                    flag = false;
                }
            }
            //表示为新Record
            if (flag) {
                record.name = name;
                record.line = num;
                record.count = 1;
                errors.add(record);
            }
        }
        input.close();
        //最多纪录8条错误纪录
        int j = 0;
        if (errors.size() > 8){
            j = errors.size() - 8;
        }
        for (; j < errors.size(); j++) {
            System.out.println(errors.get(j));
        }
    }
}
