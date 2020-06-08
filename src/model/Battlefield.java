// This  class represents the battlefield with the IDs of the tiles used
package model;

import model.enemy.Enemy;
import model.projectile.Projectile;
import model.turret.Turret;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Battlefield {
	
	private Terrain terrain;
	private ObservableList<Enemy> enemyList;
	private ObservableList<Turret> turretList;
	private Graph graph;
	private ObservableList<Projectile> projectileList;
	private int turn_number;

	public Battlefield(String path) {
		this.terrain = new Terrain(path);
		this.enemyList = FXCollections.observableArrayList();
		this.turretList = FXCollections.observableArrayList();
		this.projectileList = FXCollections.observableArrayList();
		this.graph = new Graph(this.terrain);
		this.graph.createBFS();
		this.turn_number=0;
	}

	public void turnLoop() {
		this.turn_number++;
		for (int i = getEnemyList().size() - 1 ; i >= 0 ; i--) {
			this.enemyList.get(i).action();
		}

		for (int i = getTurretList().size() - 1 ; i >= 0 ; i--) {
			this.turretList.get(i).action();
		}
		
	}
	
	public int getTurnNumber() {
		return this.turn_number;
	}

	public void addEnemy(Enemy enemy) {
		this.enemyList.add(enemy);
	}

	public void removeEnemy(Enemy enemy) {
		this.enemyList.remove(enemy);
	}
	
	public void addTurret(Turret t) {
		this.turretList.add(t);
	}
	
	public void addProjectile(Projectile projectile) {
		this.projectileList.add(projectile);
	}
	
	public void removeProjectile(Projectile projectile) {
		this.projectileList.remove(projectile);
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
	
	public ObservableList<Projectile> getProjectileList() {
		return this.projectileList;
	}
	
	public Graph getGraph() {
		return this.graph;
	}
}
