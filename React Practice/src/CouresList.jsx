import heroImg from './assets/hero.png'
import firstImg from './assets/first.png'
import secondImg from './assets/second.png'
import newImg from './assets/new.png'
import Course from './Course.jsx'
import { useState } from "react"

function CourseList(){

  
    const [courses, setCourses] = useState([
        {
            id : 1,
            courseName : "HTML Course",
            price : 90, 
            Myimage : heroImg,
            Rating : "7"
          },
         
          {
            id : 2,
         courseName : "Css Course",
         price : 100, 
         Myimage : firstImg,
         Rating : "7"
         },
         { 
            id : 3,
        courseName : "js Course",
         price : 110, 
         Myimage : secondImg,
         Rating : 7
          },
          {
            id : 4,
            courseName : "React Course",
            price : 120,
            Myimage : newImg,
            Rating : 6
          },
          {

          }
    ]);
    function handelDelete(id){
        const newCourses = courses.filter((course)=> course.id !== id);
        setCourses(newCourses);
    }
   // const vfmCourses = courses.filter((course)=> course.price<=110);
    courses.sort((a, b) => a.price - b.price);
    const coursesList = courses.map(
        (course) => 
            <Course
        key={course.id}
         name={course.courseName}
        image={course.Myimage} 
        price={course.price}
         Rating={course.Rating}
         delete={handelDelete}
         id={course.id}/>);

        return (
            <> {coursesList}</>
        );
    

}
export default CourseList;