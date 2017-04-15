package lab4;

import java.io.*;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AttackMonitor {
//I replaced the csv saving with the binary file i/o saving
	private List<MonsterAttack> attacks = new ArrayList<MonsterAttack>();
	
	public void operator() {
		String[] choices = { "Quit", "Input Monster Info", "Show Attacks", "Remove Attack", "Save List" , "Import List"};

		int choice = 0;
		String name = null;
		String date = null;
		String place = null;
		int victims = 0;
		int id = 0;
		int remover;
		
		//menu
		do {
			choice = JOptionPane.showOptionDialog(null, "OPERATOR OPTIONS", "Main Menu", 0,
					JOptionPane.QUESTION_MESSAGE, null, choices, "null");

			switch (choice) {

			//quit
			case 0:
				break;
			//add
			case 1:
				id = Integer.parseInt(JOptionPane.showInputDialog("Monster ID Number:"));
				name = JOptionPane.showInputDialog("What is it's name?");
				date = JOptionPane.showInputDialog("When did " + name + " attack? (MM/DD/YYYY)");
				place = JOptionPane.showInputDialog("Where did " + name + " attack?");
				victims = Integer.parseInt(JOptionPane.showInputDialog("How many died from the attack?"));

				MonsterAttack newAtk = new MonsterAttack(id, date, name, place, victims);

				attacks.add(newAtk);
				break;
			//show
			case 2:
				if (!(attacks.isEmpty())) {
					for (int i = 0; i < attacks.size(); i++) {
						JOptionPane.showMessageDialog(null, attacks.get(i));
					}
				} else {
					JOptionPane.showMessageDialog(null, "We're safe!");
				}
				break;
			//remove
			case 3:
				remover = Integer.parseInt(
						JOptionPane.showInputDialog("ENTER THE ID NO. OF THE ATTACK YOU WANT DELETED\n" + attacks));

				for (int i = 0; i < attacks.size(); i++) {
					if (remover == (attacks.get(i).getId())) {
						attacks.remove(i);
					}
				}
			//save
			case 4:
				listSaver();
				break;
			//import
			case 5:
				listImport();
			}
			
		} while (choice != 0);

	}
	
	//saves csv
	public void listSaver() {
//		File outFile = new File(JOptionPane.showInputDialog("Where is it going"));
//
//		BufferedWriter writer;
//		try {
//			writer = new BufferedWriter(new FileWriter(outFile));
//
//			for (int i = 0; i < attacks.size(); i++) {
//				writer.write(attacks.get(i).getId() + "," + attacks.get(i).getName() + "," + attacks.get(i).getDate() + "," + attacks.get(i).getPlace() + "," + attacks.get(i).getVictims() + "\n");
//			}
//			writer.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		BinaryMonsterPersister persister = new BinaryMonsterPersister();
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(null);
		
		if(retVal == JFileChooser.APPROVE_OPTION){
			File outFile = fc.getSelectedFile();
			persister.saveListToFile(outFile, attacks);
		}
		

	}
	
	//clear and import
	public void listImport(){
//		File inFile;
//		Scanner reader;
//		String line;
//		String[] fields;
//		int id;
//		String date;
//		String name;
//		String place;
//		int victims;
//		
		//clears list
		attacks.clear();
		
//		inFile = new File(JOptionPane.showInputDialog("Where is the file? " + attacks.size()));
//		
//		try {
//			reader = new Scanner(inFile);
//			
//			while(reader.hasNextLine()){
//				line = reader.nextLine();
//				fields = line.split(",");
//				id = Integer.parseInt(fields[0]);
//				name = fields[1];
//				date = fields[2];
//				place = fields[3];
//				victims = Integer.parseInt(fields[4]);
//				
//				attacks.add(new MonsterAttack(id, date, name, place, victims));
//			}
//			reader.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		BinaryMonsterPersister persister = new BinaryMonsterPersister();
		JFileChooser fc = new JFileChooser();
		int retVal = fc.showOpenDialog(null);
		if (retVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			attacks = persister.readListFromFile(selectedFile);
		}
		
	}
}