package dat.sub;

import java.sql.SQLException;

import db.connect.MyExecuteData;
import db.connect.MyGetData;
import db.define.DBConfig;
import db.define.MyTableModel;

public class UnSubscriber
{
	public MyExecuteData mExec;
	public MyGetData mGet;
	

	public UnSubscriber(DBConfig mConfigObj) throws Exception
	{
		try
		{
			mExec = new MyExecuteData(mConfigObj);
			mGet = new MyGetData(mConfigObj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	
	/**
	 * Lấy dữ liệu
	 * 
	 * @param Type
	 *            <p>
	 *            Type = 0: Lấy dữ liệu mẫu
	 *            </p>
	 * @param Para_1
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public MyTableModel Select(int Type) throws Exception
	{
		try
		{
			String Arr_Name[] = { "Type" };
			String Arr_Value[] = { Integer.toString(Type) };

			return mGet.GetData_Pro("Sp_UnSubscriber_Select", Arr_Name, Arr_Value);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param Type
	 *            <p>
	 *            Type = 2: Lấy chi tiết 1 Record (Para_1 = PID, Para_2 =
	 *            MSISDN, Para_3 = ServiceID)
	 *            </p>
	 * @param Para_1
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public MyTableModel Select(int Type, String Para_1, String Para_2, String Para_3) throws Exception, SQLException
	{
		try
		{
			String Arr_Name[] = { "Type", "Para_1", "Para_2", "Para_3" };
			String Arr_Value[] = { Integer.toString(Type), Para_1, Para_2, Para_3 };

			return mGet.GetData_Pro("Sp_UnSubscriber_Select", Arr_Name, Arr_Value);
		}
		catch (SQLException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * 
	 * @param Type
	 *            <p>
	 *            Type = 3: Lấy danh sách (Para_1 = RowCount, Para_2 = PID,
	 *            Para_3 = ServiceID, Para_4 = OrderID )
	 *            </p>
	 * @param Para_1
	 * @param Para_2
	 * @param Para_3
	 * @param Para_4
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public MyTableModel Select(int Type, String Para_1, String Para_2, String Para_3, String Para_4) throws Exception, SQLException
	{
		try
		{
			String Arr_Name[] = { "Type", "Para_1", "Para_2", "Para_3", "Para_4" };
			String Arr_Value[] = { Integer.toString(Type), Para_1, Para_2, Para_3, Para_4 };

			return mGet.GetData_Pro("Sp_UnSubscriber_Select", Arr_Name, Arr_Value);
		}
		catch (SQLException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * 
	 * @param Type
	 * <p>Type = 2: Lấy tất cả dịch vụ 1 số điện thoại (Para_1 = PID, Para_2 = MSISDN)</p>
	 * @param Para_1
	 * @param Para_2
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public MyTableModel Select(int Type, String Para_1, String Para_2) throws Exception, SQLException
	{
		try
		{
			String Arr_Name[] = { "Type", "Para_1", "Para_2" };
			String Arr_Value[] = { Integer.toString(Type), Para_1, Para_2 };

			return mGet.GetData_Pro("Sp_UnSubscriber_Select", Arr_Name, Arr_Value);
		}
		catch (SQLException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param Type
	 * <p>Type = 0: Update full</p>
	 * <p>Type = 1: Update thông tin PUsh MT</p>
	 * @param XMLContent
	 * @return
	 * @throws Exception
	 */
	public boolean Update(int Type, String XMLContent) throws Exception
	{
		try
		{
			String[] Arr_Name = { "Type", "XMLContent" };
			String[] Arr_Value = { Integer.toString(Type), XMLContent };
			return mExec.Execute_Pro("Sp_UnSubscriber_Update", Arr_Name, Arr_Value);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}	

	public boolean Insert(int Type, String XMLContent) throws Exception
	{
		try
		{
			String[] Arr_Name = { "Type", "XMLContent" };
			String[] Arr_Value = { Integer.toString(Type), XMLContent };
			return mExec.Execute_Pro("Sp_UnSubscriber_Insert", Arr_Name, Arr_Value);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	/**
	 * Di chuyển từ Unsub sang table Sub
	 * @param Type
	 * @param XMLContent
	 * @return
	 * @throws Exception
	 */
	public boolean Move(int Type, String XMLContent) throws Exception
	{
		try
		{
			mExec.UseTransaction = true;
			String[] Arr_Name = { "Type", "XMLContent" };
			String[] Arr_Value = { Integer.toString(Type), XMLContent };
			return mExec.Execute_Pro("Sp_UnSubscriber_Move", Arr_Name, Arr_Value);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * Xóa dữ liệu
	 * @param Type
	 * <p>Type = 4: Xóa dữ liếu với PID, MSISDN, ServiceID</p>
	 * @param XMLContent
	 * @return
	 * @throws Exception
	 */
	public boolean Delete(int Type, String XMLContent) throws Exception
	{
		try
		{
			String[] Arr_Name = { "Type", "XMLContent" };
			String[] Arr_Value = { Integer.toString(Type), XMLContent };
			return mExec.Execute_Pro("Sp_UnSubscriber_Delete", Arr_Name, Arr_Value);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public boolean Delete(Integer PID, String MSISDN , Integer ServiceID) throws Exception
	{
		try
		{
			String XMLContent = "<Parent><Child><PID>"+PID+"</PID><MSISDN>"+MSISDN+"</MSISDN><ServiceID>"+ServiceID+"</ServiceID></Child></Parent>";
			return Delete(4, XMLContent);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}
