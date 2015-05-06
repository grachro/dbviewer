package com.grachro.dbviewer.script;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.grachro.dbviewer.Command;
import com.grachro.dbviewer.Database;
import com.grachro.dbviewer.DefaultScript;
import com.grachro.dbviewer.ScriptHolder;

@ScriptHolder
public class SampleScript2 extends DefaultScript {

	public SampleScript2() {
		super("2 ページで検索");
	}

	@Override
	public List<String> getUseParams() {
		List<String> list = new ArrayList<String>();
		list.add("pageTitle");
		return list;
	}

	@Override
	public void doScript(List<Database> databaseList, List<Command> commandList, Map<String, String> sqlParams) {
		Database db = databaseList.get(0);

		String pageTitle = sqlParams.get("pageTitle");

		Command command1 = new Command("ページ", "select * from pages where title='" + pageTitle + "'");
		commandList.add(command1);
		command1.execute(db);

		String sql2 = "select * from category_page where title='" + pageTitle + "'";
		Command command2 = new Command("ページのカテゴリ", sql2);
		commandList.add(command2);
		command2.execute(db);

	}

}
