import { useState } from "react";

const course1 = "Html"

function Course(props) {
    
    const [purchased, setPurchased] = useState(false);
    
    function BuyCourse(discount,e){
        console.log(props.name,"purchsed",discount,"discount applied");
        console.log(e);
        setPurchased(true);
        console.log(purchased);}
     return (

       props.name &&   <div className={"card"}>
            <img src={props.image} alt="" />
            <h2>Course Title</h2>
            <h3>{props.name}</h3>
            <h2>{props.price}</h2>
            <button onClick={() => BuyCourse(20)}> Buy now </button>
            <button onClick={() => props.delete(props.id)}> Delete </button>
            <p>{purchased ? "Course purchased!" : "Get it now"}</p>
        </div>
    ); 
}
export default Course;
