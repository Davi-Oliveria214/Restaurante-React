import styles from '../css/Banner.module.css'
import bannerImg from '../assets/imgs/banner.png'

export default function Banner() {
    return (
        <div className={styles.banner}>
            <img src={bannerImg} alt="" />
            <h1>Bem Vindo</h1>
        </div>
    )
}