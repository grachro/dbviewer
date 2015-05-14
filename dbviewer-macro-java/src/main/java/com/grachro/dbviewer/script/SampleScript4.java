package com.grachro.dbviewer.script;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.grachro.dbviewer.Command;
import com.grachro.dbviewer.Database;
import com.grachro.dbviewer.DefaultScript;
import com.grachro.dbviewer.ScriptHolder;

@ScriptHolder
public class SampleScript4 extends DefaultScript {

	public SampleScript4() {
		super("4 SQL編集");
	}

	@Override
	public List<String> getUseParams() {
		return Collections.emptyList();
	}

	@Override
	public void doScript(List<Database> databaseList, List<Command> commandList, Map<String, String> sqlParams) {
		Database db = databaseList.get(0);

		Command command1 = editSqlOnly(db, commandList, "ページの一覧", "select * from pages order by title");
		
		editSqlOnly(db, commandList, "カテゴリの一覧", "select * from categories order by category_name ");

		String firstTitle = command1.getFirstVal("title");
		String sql3 = "select * from category_page where title='" + firstTitle + "'";
		editSqlOnly(db, commandList, "最初のページのカテゴリ", sql3);

		String lastTitle = command1.getLastVal("title");
		String sql4 = "select * from category_page where title='" + lastTitle + "'";
		editSqlOnly(db, commandList, "最初のページのカテゴリ", sql4);

	}

}
