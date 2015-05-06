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

		Command command1 = new Command("ページ", "select * from pages where title='" + pageTitle + "'");
		commandList.add(command1);
		command1.execute(db);

		String sql2 = "select * from category_page where title='" + pageTitle + "'";
		Command command2 = new Command("ページのカテゴリ", sql2);
		commandList.add(command2);
		command2.execute(db);

	}

}
