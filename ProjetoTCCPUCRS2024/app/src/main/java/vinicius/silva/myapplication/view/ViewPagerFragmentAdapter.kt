package com.example.projet_tcc_pucrs_2024.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.projet_tcc_pucrs_2024.view.ui.dashboard.DashboardFragment
import com.example.projet_tcc_pucrs_2024.view.ui.home.HomeFragment
import com.example.projet_tcc_pucrs_2024.view.ui.notifications.NotificationsFragment


class ViewPagerFragmentAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return DashboardFragment()
            1 -> return HomeFragment()
            2 -> return NotificationsFragment()
            3 -> return NotificationsFragment()
        }
        return HomeFragment()
    }

    override fun getItemCount(): Int {
        return 4 //retorna o tamanho dos elementos contidos no tabMenu. No cenário do app, no momento, 2
    }
}

