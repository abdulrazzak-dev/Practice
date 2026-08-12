import { useState, useEffect } from "react";
const useFetch = (url) => {
    const [data, setdata] = useState(null);
    const [dummy, setDummy] = useState(true);
    const [error, setError] = useState(null);
    useEffect(()=>{
        console.log('Use Effect Called');
        console.log(dummy);
        setTimeout(()=>{
        fetch(url)
        .then((response) =>
           {if (!response.ok) {
                throw Error('Could not fetch the data from the server');
             }
            return response.json()}
             )
        .then((data) => {
            setdata(data)
        })
        .catch((error) => {
            console.log(error);
            setError(error.message);
        });
    },1000);
    },[]);
    return [data,dummy,error ]
}


export default useFetch;