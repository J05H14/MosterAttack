package lab4;

import java.io.*;
import java.util.List;

public class BinaryMonsterPersister implements MonsterPersister{

	@Override
	public void saveListToFile(File f, List<MonsterAttack> a) {
		ObjectOutputStream out = null;
		
		try{
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			out.writeObject(a);
			out.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<MonsterAttack> readListFromFile(File f) {
		ObjectInputStream in = null;
		List<MonsterAttack> l = null;
		try{
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			
			l = (List<MonsterAttack>) in.readObject();
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return l;
	}

}
