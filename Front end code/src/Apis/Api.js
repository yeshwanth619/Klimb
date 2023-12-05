import axios from 'axios';



// Function to fetch data from the server based on a time range
export const getApiData = async (startTime, endTime) => {
  const apiUrl = `http://localhost:8080/rates/all?startTime=${startTime}&endTime=${endTime}`;

  try {
    const response = await axios.get(apiUrl);
    return response.data;
  } catch (error) {
    throw error; // Handle any errors that occur during the request
  }
};


