package ranzhi;

import java.lang.reflect.Member;
import java.util.Objects;

public class Tests {

	private BoxDriver baseDriver = null;
	private String baseUrl = null;
	private LoginPage loginPage = null;
	private AdminPage adminPage = null;
	
	this.loginPage = new LoginPage(this.baseDriver); 
	this.adminPage = new AdminPage(this.baseDriver);
	
	loginPage.open(this.baseUrl);    
    loginPage.changeLanguage(lang);
    loginPage.login("admin", "123456", true);
    loginPage.selectApp(AppType.Admin);
    adminPage.clickAddMemberButton();
    adminPage.addMemberData(member);
    
 // 布尔型 true false
    boolean isFirstLine = true;
    // 循环每一个行，接下来根据每一行的值（数据），进行测试
    for (CSVRecord row : csvData) {
      if (isFirstLine) {
        isFirstLine = false;
        continue;
        // continue的作用
        // 当前循环到此为止，直接进入下一条循环
      }
 Member member = new Member();
 member.setAccount(row.get(0));
 member.setRealName(row.get(1));
 if (Objects.equals(row.get(2), "f")) {
   member.setGender(Member.Gender.Female);
 } else {
   member.setGender(Member.Gender.Male);
 }


 member.setDept(Integer.parseInt(row.get(3)));
 member.setRole(Integer.parseInt(row.get(4)));
 member.setPassword(row.get(5));
 member.setEmail(row.get(6));
 // TODO: 进行测试

    }
}
