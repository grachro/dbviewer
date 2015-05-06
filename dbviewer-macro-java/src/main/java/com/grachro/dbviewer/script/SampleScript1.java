package com.grachro.dbviewer.script;

import java.util.List;
import java.util.Map;

import com.grachro.dbviewer.Command;
import com.grachro.dbviewer.Database;
import com.grachro.dbviewer.DefaultScript;
import com.grachro.dbviewer.ScriptHolder;

@ScriptHolder
public class SampleScript1 extends DefaultScript {

	public SampleScript1() {
		super("1 一覧表示");
	}

	@Override
	public void doScript(List<Database> databaseList, List<Command> commandList, Map<String, String> sqlParams) {
		Database db = databaseList.get(0);

		Command command1 = new Command("ページの一覧", "select * from pages order by title");
		commandList.add(command1);
		command1.execute(db);

		Command command2 = new Command("カテゴリの一覧", "select * from categories order by category_name ");
		commandList.add(command2);
		command2.execute(db);

		String firstTitle = command1.getFirstVal("title");
		String sql3 = "select * from category_page where title='" + firstTitle + "'";
		Command command3 = new Command("最初のページのカテゴリ", sql3);
		commandList.add(command3);
		command3.execute(db);

		String lastTitle = command1.getLastVal("title");
		String sql4 = "select * from category_page where title='" + lastTitle + "'";
		Command command4 = new Command("最初のページのカテゴリ", sql4);
		commandList.add(command4);
		command4.execute(db);

	}

}
