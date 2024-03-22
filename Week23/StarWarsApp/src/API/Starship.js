import axios from 'axios';

const BASE_URL = import.meta.env.VITE_APP_API_BASE_URL;
export const getStarships = async () => {
    const {data} = await axios.get(`${BASE_URL}starships`);
    return data;
}

export const getStarship = async (id) => {
    const {data} = await axios.get(`${BASE_URL}starships/${id}`);
    return data;
}