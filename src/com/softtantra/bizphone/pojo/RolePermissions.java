package com.softtantra.bizphone.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role_permissions")
public class RolePermissions {
	
	 @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

		private String name;
		private int status;
		private String role_title;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "RolePermissions [id=" + id + ", name=" + name
					+  ", status=" + status + "]";
		}
		public String getRole_title() {
			return role_title;
		}
		public void setRole_title(String role_title) {
			this.role_title = role_title;
		}
		
		
		
		
		
		
		

}
