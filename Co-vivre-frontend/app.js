import 'regenerator-runtime/runtime';
import axios from 'axios';

const BASE_URL='http://localhost:8080/api/v1/data';
var hello;
const getgreeting = async() => {
    try{
        const response = await axios.get(`${BASE_URL}/greeting`);
        const greetingItems=response.data;
        console.log(`GET: Here's the greeting`,greetingItems);
        hello=response.data;
        return greetingItems;
    }catch (errors){
        console.log(errors);
    }
};

window.onload = (event) => {
    getgreeting();
};
