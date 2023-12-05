import React, { useState } from 'react';

import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import './timeSelector.css';
import { getDateFunction } from '../reuseFunctions/reuse';

import {
  timeRangeHeading,
  last24Hours,
  last7days,
  startDatePlaceHolder,
  endDatePlaceHolder,
  timeRange,
} from '../../Constants/constants.js';

const TimeRangeSelector = (props) => {
 

  const [startDate, setStartDate] = useState(null);
  const [endDate, setEndDate] = useState(null);
  const [startTimeApi, setStartTimeApi] = useState();
  const [endTimeApi, setEndTimeApi] = useState();
  const [isButtonDisabled, setIsButtonDisabled] = useState(false);
  const [errorMessage, setErrorMessage] = useState('Select the Date Range');



  const handleStartDateChange = (date) => {
    setStartDate(date);
    let dateObj=getDateFunction(date)
    
    

      let formattedStartDate = `${dateObj.year}-${dateObj.month}-${dateObj.day}T${dateObj.hours}:${dateObj.minutes}:00`;
    setStartTimeApi(formattedStartDate);
    validateDates(date, endDate);
  };


  const handleEndDateChange = (date) => {
    setEndDate(date);
    let dateObj=getDateFunction(date)
    

     let formattedEndDate = `${dateObj.year}-${dateObj.month}-${dateObj.day}T${dateObj.hours}:${dateObj.minutes}:00`;
    setEndTimeApi(formattedEndDate);
    validateDates(startDate, date);
  };

  
  const validateDates = (start, end) => {
    if (start && end && start <= end) {
      setIsButtonDisabled(false);
      setErrorMessage('Select the Date Range');
    } else {
      setIsButtonDisabled(true);
      setErrorMessage('End date must be greater than start date');
    }
  };

 
  const handleClickSubmit = async () => {
    props.dataFunction(startTimeApi, endTimeApi);
  };

  return (
    <div>
      <h2 className='timeHeader'>{timeRangeHeading}</h2>
    
     
        <div className="date-picker-container">
          <DatePicker
            selected={startDate}
            onChange={handleStartDateChange}
            showTimeSelect
            timeFormat="HH:mm"
            dateFormat="yyyy-MM-dd HH:mm"
            placeholderText={startDatePlaceHolder}
          />
          <DatePicker
            selected={endDate}
            onChange={handleEndDateChange}
            showTimeSelect
            timeFormat="HH:mm"
            dateFormat="yyyy-MM-dd HH:mm"
            placeholderText={endDatePlaceHolder}
          />
        </div>
      
      <button className={isButtonDisabled ? "buttonClr" : ""} onClick={handleClickSubmit} disabled={isButtonDisabled} title={errorMessage}>
        Submit
      </button>
    </div>
  );
};

export default TimeRangeSelector;
