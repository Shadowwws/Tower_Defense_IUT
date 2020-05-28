// This  class represents the battlefield with the IDs of the tiles used
package model;

import model.enemy.Enemy;
import model.turret.Turret;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Battlefield {
	
	private Terrain terrain;
	private ObservableList<Enemy> enemyList;
	private ObservableList<Turret> turretList;
	private Graph graph;

	public Battlefield(String path) {
		this.terrain = new Terrain(path);
		this.enemyList = FXCollections.observableArrayList();
		this.turretList = FXCollections.observableArrayList();
		this.graph = new Graph(this.terrain);
		this.graph.createBFS();
	}
	
	public void addEnemy(Enemy enemy) {
		this.enemyList.add(enemy);
	}
	
	public void addTurret(Turret t) {
		this.turretList.add(t);
	}
	
	public Terrain getTerrain() {
		return this.terrain;
	}
		
	public ObservableList<Enemy> getEnemyList(){
		return this.enemyList;
	}
	
	public ObservableList<Turret> getTurretList(){
		return this.turretList;
	}
	
	public Graph getGraph() {
		return this.graph;
	}

}
