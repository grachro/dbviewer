package com.grachro.dbviewer.script;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import com.grachro.dbviewer.Script;

public class AllGroovyScripts {

	private String scriptDirPath;

	/** DIフィールド */
	public void setScriptDirPath(String scriptDirPath) {
		this.scriptDirPath = scriptDirPath;
	}

	public Set<Script> getScriptList() {
		Set<Script> result = new HashSet<Script>();
		addGroovyScript(result);
		return result;
	}

	public void addGroovyScript(Set<Script> scriptList) {
		try {
			GroovyScriptEngine gse = new GroovyScriptEngine(this.scriptDirPath);

			Binding bind = new Binding();
			bind.setVariable("scriptList", scriptList);

			Object result = gse.run("main.groovy", bind);
			Logger.getLogger(getClass().getName()).info("grrovy.status=" + result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
