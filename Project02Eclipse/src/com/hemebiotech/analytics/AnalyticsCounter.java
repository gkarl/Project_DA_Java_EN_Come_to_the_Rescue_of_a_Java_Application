package com.hemebiotech.analytics;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	/**
	 *
	 * @param args
	 * @throws Exception
	 */
	
	public static void main(String args[]) throws Exception {
		// la key représente un symptome et Integer représente l'occurence = compteur
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		// BufferedReader va aider à lire le fichier symptoms.txt,
		// des exception peuvent survenir bonne pratique de l'entourer avec blocs try catch
		// BufferReader a dans son constructeur la class FileReader
		BufferedReader reader = null;
		try{
			// first get input
			reader = new BufferedReader (new FileReader("symptoms.txt"));

			// Maintenant le programme doit lire le fichier symptoms.txt ligne par ligne avec le type String
			// Bonne partique rajouter un bloc catch si des exception surviennent avec la méthode readLine()
			String line = reader.readLine();
			// tant que on arrive pas sur une ligne null cad aucun mot sur la ligne
			while(line != null) {
				// si on avais une erreur sur le fichier symptoms.txt avec plusieurs symptomes sur la meme ligne avec des espace
				// toLowerCase nous permet de mettre en minuscule tous les mots trouvé sur une ligne afin qu'un symptoms avec ou sans majuscule soit bien comptabilé
				// la méthode split() permet d'enlever les espace pour ne garder que les mots
				// que l'on stock dans une variable Array de type String
				String words[] = line.toLowerCase().split(" ");

				//Pour lire ces mots (symptomes) un par un dans le Array on utilise une boucle for
				for(String word : words){
					// si le mot (symptome) = key  est déja dans le HashMap
					if(wordMap.containsKey(word)){
						// get permet de retrouver ce mot (symptome key) dans le HashMap ensuite rajoute plus 1 au compteur (value)
						wordMap.put(word, wordMap.get(word)+1);
					}else{
						// alors si le symptom trouvé n'est pas dans le HashMap, on rajoute le mot avec l'occurence 1
						wordMap.put(word, 1);
					}
				}
				// a ce stade nous n'avons lu que la premiére ligne de symptom.txt
				//on doit déplacer le cursseur à la ligne suivante
				line = reader.readLine(); // get another symptom
			}

		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}


		finally {
			// Une foi la lecture du de symptoms.txt terminé on ferme le flux de lecture avec ce fichier
			// et quand on le ferme reader des exception peuvent survenir, bonne pratique de l'entourer avec blocs try catch
			try{
				reader.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		// affiche le décompte des symptomes dans la console
		wordMap.forEach((k,v) -> System.out.println(k + " : " + v));

		TreeMap<String, Integer> triMap = new TreeMap<>();
		triMap.putAll(wordMap);

		// affiche le décompte des symptomes par ordre alphabétique dans la console
		System.out.println("_________________________________________________________ Sorted List \n");
		triMap.forEach((k,v) -> System.out.println(k + " : " + v));

		int SymptomsTotal = 0;
		try{
			// next generate output
			FileWriter writer = new FileWriter ("result.out");
			//writer.write(String.valueOf(wordMap));
			for ( Map.Entry<String, Integer> entry  : triMap.entrySet()) {
				writer.write(entry.getKey() + " = " + entry.getValue() + "\n");
				SymptomsTotal += entry.getValue();
			}
			writer.write("Symptoms variations= " + triMap.size() + " Total of symptoms = " + SymptomsTotal);
			writer.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
