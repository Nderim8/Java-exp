
import java.util.HashSet;
import java.util.Set;

import jdk.nashorn.api.tree.Tree;





public class Task1 {

	public int solution(Tree T){
		Set<String> val = new HashSet<>();
		if(T == null){
			return 0;
		}
		return getMax(T, val);
	}
	
	private static int getMax(Tree T, Set<String> val){
		if(T == null){
			return val.size();
		}
		int l = 0;
		int r  = 0;
		if(val.add(T.data)){
			l = getMaxHelper(T->left, val);
			r = getMaxHelper(T.right, val);
			val.remove(val.size()-1);
		}
		else{
			l = getMax(T.left, val);
			r = getMax(T.right, val);
		}
		return Math.max(l, r);
}
	
}
