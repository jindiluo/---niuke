package �򵥴����¼;

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
//������Ҫѧϰsubstring�ķ���������lastindexof()����
            boolean flag = true;
            //�ظ�����
            for (Error error : errors) {
                if (name.equals(error.name) && num == error.line) {
                    error.count++;
                    flag = false;
                }
            }
            //��ʾΪ��Record
            if (flag) {
                record.name = name;
                record.line = num;
                record.count = 1;
                errors.add(record);
            }
        }
        input.close();
        //����¼8�������¼
        int j = 0;
        if (errors.size() > 8){
            j = errors.size() - 8;
        }
        for (; j < errors.size(); j++) {
            System.out.println(errors.get(j));
        }
    }
}
