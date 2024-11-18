//
//  AlarmCardView.swift
//  iosApp
//
//  Created by Kuei Jung Hu on 2024/11/08.
//  Copyright © 2024 Kuei-Jung Hu. All rights reserved.
//

import SwiftUI

struct AlarmCardView: View {
    
    enum TimePeriod {
        case am
        case pm
    }
    
    let title: String
    let time: String
    let period: TimePeriod
    let remainginTimeText: String
    @State var toggleIsOn: Bool

    var body: some View {
        ZStack {
            HStack(alignment: .top) {
                VStack(alignment: .leading) {
                    Text(title)
                        .font(.headline)
                        .foregroundColor(.onSurface)
                    
                    HStack(alignment: .lastTextBaseline) {
                        Text(time)
                            .font(.extraLarge)
                            .foregroundColor(.onSurface)
                        
                        Text("\(period)".uppercased())
                            .font(.title)
                            .foregroundColor(.onSurface)
                    }
                    
                    Text(remainginTimeText)
                        .font(.title3)
                        .foregroundStyle(.secondary)
                }.frame(maxWidth: .infinity, alignment: .topLeading)
                
                Toggle(isOn: $toggleIsOn, label: {})
                    .labelsHidden()
                    .tint(.primary)
            }
            .padding(20)
            
        }
        .background(Color.white)
        .clipShape(RoundedRectangle(cornerRadius: 10))
    }
}

#Preview {
    ZStack {
        Rectangle().foregroundColor(.gray)
        AlarmCardView(
            title: "Wake Up",
            time: "10:00",
            period: .am,
            remainginTimeText: "Alarm in 30min",
            toggleIsOn: true
        )
    }
}
