import java.util.List;
import java.util.Map;

import com.grachro.dbviewer.Command;
import com.grachro.dbviewer.Database;
import com.grachro.dbviewer.DefaultScript;

public class SampleScript2 extends DefaultScript {

	public SampleScript2() {
		super("2 ページで検索");
		addParameter("pageTitle", "ページタイトル","例：Java or Ruby");
	}

	@Override
	public void doScript(List<Database> databaseList, List<Command> commandList, Map<String, String> sqlParams) {
		Database db = databaseList.get(0);

		String pageTitle = sqlParams.get("pageTitle");

		execute(db, commandList, "ページ", "select * from pages where title='" + pageTitle + "'");

		String sql2 = "select * from category_page where title='" + pageTitle + "'";
		execute(db, commandList, "ページのカテゴリ", sql2);

	}

}