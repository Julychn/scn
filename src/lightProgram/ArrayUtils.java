package lightProgram;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ArrayUtils
{
	/**
	 * ����һ�����߷��������߷������ַ����������ҵ���Ӧ���ַ���Ԫ�ص�λ��
	 * @param array ����������
	 * @param target �������ַ���
	 * @return Ŀ���ַ������ֵ�λ��,-1�����Ҳ���
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
