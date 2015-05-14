import java.util.List;
import java.util.Map;

import com.grachro.dbviewer.Command;
import com.grachro.dbviewer.Database;
import com.grachro.dbviewer.DefaultScript;
import com.grachro.dbviewer.ScriptHolder;


public class SampleGroovyScript extends DefaultScript {

	public SampleGroovyScript() {
		super("3 Groovy!");
	}

	@Override
	public void doScript(List<Database> databaseList, List<Command> commandList, Map<String, String> sqlParams) {
		Database db = databaseList.get(0);

		String pageTitle = 'Groovy';

		execute(db, commandList, "ページ!", "select * from pages where title='" + pageTitle + "'");

		String sql2 = "select * from category_page where title='" + pageTitle + "'";
		execute(db, commandList, "ページのカテゴリ!", sql2);
	}

}
