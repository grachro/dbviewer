package sample.script;

import java.util.HashSet;
import java.util.Set;

import com.grachro.dbviewer.Script;
import com.grachro.dbviewer.ScriptHolder;

@ScriptHolder
public class AllScripts {
	public Set<Script> getScriptList() {
		Set<Script> result = new HashSet<Script>();
		result.add(new SampleScript1());
		result.add(new SampleScript2());
		return result;
	}
}
