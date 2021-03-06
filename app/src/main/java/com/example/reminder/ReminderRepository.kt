package com.example.reminder

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

public class ReminderRepository(context: Context) {

    private var reminderDao: ReminderDao?

    init {
        val reminderRoomDatabase = ReminderRoomDatabase.getDatabase(context)
        reminderDao = reminderRoomDatabase?.reminderDao()
    }

    fun getAllReminders() : LiveData<List<Reminder>> {
        return reminderDao?.getAllReminders() ?: MutableLiveData(emptyList())
    }


    fun insertReminder(reminder: Reminder) {
        reminderDao?.insertReminder(reminder)
    }

    fun deleteReminder(reminder: Reminder) {
        reminderDao?.deleteReminder(reminder)
    }

    fun updateReminder(reminder: Reminder) {
        reminderDao?.updateReminder(reminder)
    }

}
