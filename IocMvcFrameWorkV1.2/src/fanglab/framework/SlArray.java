package fanglab.framework;

import java.text.*;
import java.util.*;

   /*
    * ����
    */
    public class SlArray
    {
    	/*
    	 * ��ÿ���
    	 * 
    	 * @param int length������
    	 * @param int n������Ϊtrue
    	 * @return ArrayList<HashMap<Integer, Boolean>>�����
    	 * 
    	 */
        public static ArrayList<HashMap<Integer, Boolean>> getPossibly(int length, int n)
        {
        	ArrayList<HashMap<Integer, Boolean>> result = new ArrayList<HashMap<Integer, Boolean>>();

            String maxFormat = "";
            String minFormat = "";

            for (int i = 0; i < length; i++)
            {
                maxFormat = maxFormat + "1";
                minFormat = minFormat + "0";
            }

            int max = Integer.valueOf(maxFormat, 2);
            int min = Integer.valueOf(minFormat, 2);

            int count = 0;

            for (int i = min; i < max; i++)
            {
                count = 0;
                String current = (new DecimalFormat(minFormat)).format(Integer.parseInt(Integer.toString(i, 2)));
                char[] array = current.toCharArray();
                HashMap<Integer, Boolean> item = new HashMap<Integer, Boolean>();

                for (int j = 0; j < array.length; j++)
                {
                    if (array[j] == '1')
                    {
                        count++;
                    }
                    item.put(j, array[j] == '1');
                }
                if (count == n)
                {
                    result.add(item);
                }
            }

            return result;
        }
    }
