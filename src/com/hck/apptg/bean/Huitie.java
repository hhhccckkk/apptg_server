package com.hck.apptg.bean;

/**
 * Huitie entity. @author MyEclipse Persistence Tools
 */

public class Huitie implements java.io.Serializable {

	// Fields

		private Long id;
		private User user;
		private String yuantie;
		private String image;
		private String time;
		private Long tid;
		private String huifu;


		public Long getId() {
			return this.id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return this.user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getYuantie() {
			return this.yuantie;
		}

		public void setYuantie(String yuantie) {
			this.yuantie = yuantie;
		}

		public String getImage() {
			return this.image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getTime() {
			return this.time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public Long getTid() {
			return this.tid;
		}

		public void setTid(Long tid) {
			this.tid = tid;
		}

		public String getHuifu() {
			return this.huifu;
		}

		public void setHuifu(String huifu) {
			this.huifu = huifu;
		}

		

		

}