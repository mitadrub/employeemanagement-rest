package com.employeemanagement.dab;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.employeemanagement.dto.EmployeeDetails;

@Repository
@Component
public class FetchEmployeeDab {

//	private static final Logger log = LoggerFactory.getLogger(FetchNewsDetailsDAB.class);

	private static final String FETCH_EMPLOYEE_DETAILS = "SELECT emp.first_name as Fisrt_Name, emp.last_name as Last_Name, emp.id as EmployeeId, group_concat(assetVal.asset_id) as AssetId\r\n"
			+ "FROM employee_management_system.employees emp \r\n"
			+ "inner join employee_management_system.assigned_asset asset on emp.id = asset.employee_id \r\n"
			+ "inner join employee_management_system.asset_val assetVal on asset.assigned_asset_id = assetVal.asset_id\r\n"
			+ "GROUP BY emp.id";
	
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private final JdbcTemplate jdbcTemplate;
	
	public FetchEmployeeDab(@Qualifier("jdbcTemplate") JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<EmployeeDetails> fetchEmployeeDetails() {
		final List<EmployeeDetails> empDetails = jdbcTemplate.query(FETCH_EMPLOYEE_DETAILS,
									new RowMapper<EmployeeDetails>() {
			@Override
			public EmployeeDetails mapRow(ResultSet rs, int rownumber) throws SQLException {
				final EmployeeDetails details = new EmployeeDetails();
				details.setEmployeeName(rs.getString("Fisrt_Name")+" "+rs.getString("Last_Name"));
				details.setEmployeeId(rs.getInt("EmployeeId"));
				String s = rs.getString("AssetId");
					String[] arrayOfAssetId = s.split(",", s.length());
					List<Integer> list = new ArrayList<>();
					for (String s1 : arrayOfAssetId) {
						list.add(Integer.parseInt(s1));
					}
					details.setAssetId(list);
				return details;
			}
		});
		return empDetails;
	}
}
