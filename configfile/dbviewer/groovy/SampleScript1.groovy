import java.util.List;
import java.util.Map;

import com.grachro.dbviewer.Command;
import com.grachro.dbviewer.Database;
import com.grachro.dbviewer.DefaultScript;

public class SampleScript1 extends DefaultScript {

	public SampleScript1() {
		super("1 一覧表示");
	}

	@Override
	public void doScript(List<Database> databaseList, List<Command> commandList, Map<String, String> sqlParams) {
		Database db = databaseList.get(0);

		Command command1 = execute(db, commandList, "ページの一覧", "select * from pages order by title");

		execute(db, commandList, "カテゴリの一覧", "select * from categories order by category_name ");

		String firstTitle = command1.getFirstVal("title");
		String sql3 = "select * from category_page where title='" + firstTitle + "'";
		execute(db, commandList, "最初のページのカテゴリ", sql3);

		String lastTitle = command1.getLastVal("title");
		String sql4 = "select * from category_page where title='" + lastTitle + "'";
		execute(db, commandList, "最初のページのカテゴリ", sql4);

	}

}