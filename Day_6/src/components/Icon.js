import React from 'react'
import { IconButton } from '@mui/material';
import FacebookIcon from '@mui/icons-material/Facebook';
import LinkedInIcon from '@mui/icons-material/LinkedIn';
import TwitterIcon from '@mui/icons-material/Twitter';
import InstagramIcon from '@mui/icons-material/Instagram';
import "./Icon.css"

function Icon() {
  return (
    <div>

      <div className='Icon_container'>
      <IconButton style={{ color: "white" }}><FacebookIcon fontSize='large'/></IconButton>
      <br/>
      <IconButton style={{ color: "white" }}><InstagramIcon fontSize='large'/></IconButton>
      <br/>
      <IconButton style={{ color: "white" }}><LinkedInIcon fontSize='large'/></IconButton>
      <br/>
      <IconButton style={{ color: "white" }}><TwitterIcon fontSize='large'/></IconButton>
      <br/>
      
    </div>
    </div>
  )
}

export default Icon