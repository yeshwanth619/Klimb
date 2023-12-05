import React, {  useState, useEffect } from 'react';
import './DashboardPage.css'
import { dashboardHeader, graphTitle, dataTitle } from '../../Constants/constants';
import TimeSelector from '../../Functions/TimeSelector/timeSelector';
import Graph from '../../Functions/Graph/graph';


import { getApiData } from '../../Apis/Api';
import { getDateFunction } from '../../Functions/reuseFunctions/reuse';
function DashboardPage() {
 
    const [data, setData] = useState([]);


 const Data = async (startDate, endDate) => {
   
   

    try {
     
        const result = await getApiData(startDate, endDate);
     
        setData(result); 
    } catch (error) {
        console.error('Error:', error.message);
       
       return
    }

  

}




  return (
    <div>
  
      <div className='header'>{dashboardHeader}</div>


      <TimeSelector dataFunction={Data} />

 

      <div class="container text-center">
   
            <div className='analyticsTitle'>
              {graphTitle}
            </div>
            <div className='dataTitle'>
             
              <Graph data={data} />
            </div>
        
      </div>
    </div>
  );
}

export default DashboardPage;
