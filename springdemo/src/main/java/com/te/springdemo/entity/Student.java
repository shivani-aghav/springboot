package com.te.springdemo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
class Student {

	@Id
	Long id;

	@ManyToMany
	@JoinTable(name = "course_like", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	Set<Course> likedCourses;

	@OneToMany(mappedBy = "student")
	Set<CourseRating> ratings;
}
