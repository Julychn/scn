package lightProgram;

/**
 * Description: 数组工具类
 * @author scn
 * @version 1.0
 */
public class ArrayUtils
{
	/**
	 * 在数组中查找指定元素的索引，若没有该元素，返回-1
	 * @param array 数组
	 * @param target 要查找的元素值
	 * @return 返回该元素在数组中对应的索引
	 */
	public static int search(String[] array, String target)
	{
		for (int i = 0 ; i < array.length ; i++ )
		{
			if (array[i] != null && array[i].equals(target))
			{
				return i;
			}
		}
		return -1;
	}
}
