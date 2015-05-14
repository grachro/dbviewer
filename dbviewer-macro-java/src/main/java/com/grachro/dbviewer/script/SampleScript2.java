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

		execute(db, commandList, "ページ", "select * from pages where title='" + pageTitle + "'");

		String sql2 = "select * from category_page where title='" + pageTitle + "'";
		execute(db, commandList, "ページのカテゴリ", sql2);

	}

}
